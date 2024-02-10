#!/bin/bash
# Author: Jeremi Aron Chancan Labajos
path_test="/d/Documents/ObsidianGeneral/Project-Euler/TestingScripts/test.sh"
path_addtest="/d/Documents/ObsidianGeneral/Project-Euler/TestingScripts/addtest.sh"

if [[ "$1" == "-a" ]]; then
	$path_addtest "$2" "$3"
else 
	$path_test "$1"
fi
