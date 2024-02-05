#!/bin/bash
# Author: Jeremi Aron Chancan Labajos

file="$1"
extension="${file##*.}"
file_basename="${file%.*}"
file_test="test.txt"
file_output="output.txt"
file_solutions="solutions.txt"

solutions=()
tests=()
outputs=()

# Funcion para mensajes
msg() {
	RED='\033[0;31m'
	GREEN='\033[0;32m'
	RESET='\033[0m'

	local type_msg="$1"
	local name_test="$2"
	local output_case="$3"
	local answer_case="$4"

	# Usa los códigos de color
	if [[ $1 == "pass" ]]; then
		echo -e "${GREEN}Paso el Test ${name_test}${RESET}"
	elif [[ $1 == "err" ]]; then
		echo -e "${RED}NO paso el Test ${name_test}${RESET}"
		echo -e "\t${RED}Esperado: ${answer_case}${RESET}"
		echo -e "\t${RED}Salida: ${output_case}${RESET}"
	fi
}

# Funcion para hacer el test de acuerdo al lenguaje
testing() {
	local exec="$1" # Ejecutable para el archivo
	local is_compiled="$2"
	local name_file=""
	
	[[ $is_compiled -eq 1 ]] && name_file="$file_basename" || name_file="$file"

	count=0
	for output in $("$exec" "$name_file" < "$file_test"); do
		out=$(echo $output | tr -d '[:space:]') # saca los espacios y saltos de linea
		answer="${solutions[$count]}"
		test_case="${tests[$count]}"
		if [[ $answer == $out ]]; then
			msg "pass" "${file_basename}(${test_case})" "$out" "$answer"
		else
			msg "err" "${file_basename}(${test_case})" "$out" "$answer"
			echo $out
			echo $answer
			exit 1
		fi
		((count++))
		#echo $out
	done
}

# Obtener Soluciones
for line in $(cat "$file_solutions"); do
	s=$(echo "$line" | tr -d '[:space:]')
	solutions+=($s)
done

# Saber el numero de tests
num_tests=$(sed "$((1))q;d" "$file_test")

# Comprobacion de tests
if [[ $num_tests -ne ${#solutions[@]} ]]; then
	echo -e "\n\t\033[0;31mHay un error en los tests\n\033[0m"
	exit 1
fi

# Obtener Tests
for (( i=0; i < $num_tests; i++ )); do
	t=$(sed "$((i+2))q;d" "$file_test")
	tests+=($t)
done

if [[ $extension == "java" ]]; then
	echo -e "\n\tCompilando Archivo Java\n"
	javac "$file"
	testing "java" 1
	java "$file_basename" < "$file_test" > "$file_output"
elif [[ $extension == "py" ]]; then
	echo -e "\n\tEjecutando Archivo Python\n"
	testing "py"
	py $file < $file_test > $file_output
fi
