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
        console.log(smallestMult(n));
    }
}

function smallestMult(n) {
  const gcd = (a,b) => b == 0 ? a : gcd(b, a%b);
  const lcm = (a,b) => (a*b) / gcd(a,b);
  for (let i = n; i > 1; i--) n = lcm(n,i);
  return n;
}
