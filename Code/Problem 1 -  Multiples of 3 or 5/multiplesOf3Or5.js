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

function multiplesOf3Or5(number) {
    number = BigInt(number);
    
    const mulSum = (mul) => {
        let max = (number - 1n) / BigInt(mul); // Triangular number begin the multiple
        let sum = max * (max + 1n) / 2n;
        return BigInt(mul) * sum;
    }

    return BigInt(mulSum(3) + mulSum(5) - mulSum(15)).toString();
}

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(multiplesOf3Or5(n));
    }
}
