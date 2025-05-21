var convert = function (s, numRows) {
    let result = "";
    if (numRows === 1) {
        return s;
    }
    for (let i = 0; i < numRows; ++i) {
        let row = "";
        let firstHalf = i <= numRows / 2;
        let flag = firstHalf;
        let index = i;
        while (s.length > index) {
            row += s[index];
            if (i === 0 || i == numRows - 1) {
                index += numRows * 2 - 2;
            } else if (firstHalf){
                index += flag ? (numRows - i - 1) * 2: i * 2;
            } else {
                index += flag ? i * 2 : (numRows - i - 1) * 2;
            }
            flag = !flag;
        }
        result += row;
    }
    return result;
};

//console.log(convert("A", 2));

// expected PAHNAPLSIIGYIR
console.log(convert("PAYPALISHIRING", 3));

//expected PINALSIGYAHRPI
console.log(convert("PAYPALISHIRING", 4));

//
console.log(convert("ABCDEF", 5));

// P       H
// A     S    I
// Y   I         R
// P L             I    G
// A                  N

// 3 - 4
// 4 - 6
// 5 - 8
//
// x = 2a - 2
//
// 3 - 2
// 4 - 4
// 5 - 6
// 6 - 8
//
// x = a + a - 4