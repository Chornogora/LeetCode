var maxArea = function (heightArr) {
    let first = 0;
    let second = heightArr.length - 1;
    let max = 0;
    for (let i = 0; i < heightArr.length - 1; ++i) {
        if (first !== i && heightArr[i] <= heightArr[first]) {
            continue;
        }
        first = i;
        for (let j = heightArr.length - 1; j > i; --j) {
            if (second !== j && heightArr[j] <= heightArr[second]) {
                continue;
            }

            const volume = Math.min(heightArr[i], heightArr[j]) * (j - i);
            if (volume > max) {
                max = volume;
            }

            second = j;
            if (heightArr[j] >= heightArr[i]) {
                break;
            }
        }
    }
    return max;
}

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]) === 49);
console.log(maxArea([8361, 5302, 11216, 8672, 2400, 5150, 3527, 6713, 2902, 310, 555, 9176, 311, 9968, 5705, 3983, 7992, 8553, 11541, 6953]));