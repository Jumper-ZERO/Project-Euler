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
    let mulMax = (mul, max=number) => Math.floor((max-1)/mul);
    let mulSum = (num, mul) => num * (num+1) / 2 * mul;
    let mulTotal = (n) => mulSum(mulMax(n), n);
    return mulTotal(3) + mulTotal(5) - mulTotal(15);
}

function main(input) {
    let t = parseInt(input.shift());
    for(let a0 = 0; a0 < t; a0++){
        let n = parseInt(input.shift());
        console.log(multiplesOf3Or5(n));
    }
}
