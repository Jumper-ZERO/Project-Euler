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
        console.log(summationOfPrimes(n)); //print test function
    }
}

//--------------------Code--------------------

function summationOfPrimes(n) {
    let sieve = Array(n).fill(true);
    let sum = 0;

    for (let i = 2; i * i < n; i++) {
        if (sieve[i]) {
            for (let j = i*i; j < n; j+=i) {
                sieve[j] = false;
            }
        }
    }

    for (let i = 2; i < n; i++) {
        if (sieve[i]) sum += i;
    }

    return sum;
}