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
        console.log(sumSquareDifference(n));
    }
}

function sumSquareDifference(n) {
  const sum1 = n * (n+1) * (2*n+1) / 6;
  const sum2 = (n * (n+1) / 2) ** 2;
  return sum2 - sum1;
}