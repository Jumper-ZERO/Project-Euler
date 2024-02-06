#!/bin/bash
# Author: Jeremi Aron Chancan Labajos

case_test="$1"
solution="$2"

file_test="test.txt"
file_solution="solutions.txt"

touch "$file_solution"

verify() {
	num_test=$(sed -n "1p" "$file_test") 
	num_solution=$(wc -l "$file_solution" | cut -d' ' -f1)

	if [[ $num_test -ne $num_solution ]]; then
		echo -e "\n\tLos archivos $file_test y $file_solution no coinciden\n"
		sed -n '1!p' $file_test > tem
		echo -e "T(${num_test})\tS(${num_solution})"
		echo
		paste tem $file_solution
		rm tem
		exit 1;
	fi
}

add_data() {
	echo "$case_test" >> "$file_test"
	echo "$solution" >> "$file_solution"
}

if [[ -s "$file_test" ]]; then # Verificar si existe o esta vacio
	verify
	num=$(sed -n "1p" "$file_test")
	sed -i "1c$((num+1))" "$file_test"
	add_data
else
	echo "1" > "$file_test"
	add_data
fi

echo -e "\n\tAdd Test $case_test => $solution\n"
