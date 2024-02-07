#!/bin/bash
# Author: Jeremi Aron Chancan Labajos

n_problem="Problem $1"
name="$2"

dir_code="Code/$n_problem - $name"
dir_problem="Problems/"
dir_logic="Logic/"

# code directory
mkdir "$dir_code"

## add files code
file_java=$(echo "$name" | sed 's/\b\(.\)/\u\1/g' | tr -d ' ')
file_javascript=$(echo "$file_java" | sed 's/./\L&/')
file_python=$(echo "$name" | sed 's/./\L&/' | tr ' ' '_')

# problems directory
echo "# $name" > "${dir_problem}${n_problem}.md"

# logic directory
touch "${dir_logic}${n_problem} - ${name}.md"

# _________________templates_________________
## java
cat << DATA > "${dir_code}/${file_java}.java"
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ${file_java} {

    public static long resolve(int n) {
		// coding here
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(resolve(n));
        }
    }
}
DATA

## javascript
cat << DATA > "${dir_code}/${file_javascript}.js"
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', (line) => {
    input.push(line);
});

rl.on('close', () => {
    main(input);
});

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(${file_javascript}(n)); //print test function
    }
}

//--------------------Code--------------------

function ${file_javascript}() {
  // coding here
}
DATA

## python
cat << DATA > "${dir_code}/${file_python}.py"
import sys

def ${file_python}(n):
	pass # coding here

t = int(input().strip())
for a0 in range(t):
    n = int(input().strip())
    print(${file_python}(n))
DATA

# Generate testing script
dir_project="$PWD"

cat << OML > "${dir_code}/test.sh"
#!/bin/bash
# Author: Jeremi Aron Chancan Labajos
path_test="${dir_project}/TestingScripts/test.sh"
path_addtest="${dir_project}/TestingScripts/addtest.sh"

if [[ "\$1" == "-a" ]]; then
	\$path_addtest "\$2" "\$3"
else 
	\$path_test "\$1"
fi
OML

chmod +x "${dir_code}/test.sh"
