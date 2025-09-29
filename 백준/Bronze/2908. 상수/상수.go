package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func reverse(s string) (int, error) {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}

	reversedString := string(runes)
	return strconv.Atoi(reversedString)
}

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	scanner.Split(bufio.ScanWords)
	scanner.Scan()
	n1 := scanner.Text()
	scanner.Scan()
	n2 := scanner.Text()

	rev_n1, _ := reverse(n1)
	rev_n2, _ := reverse(n2)

	if rev_n1 > rev_n2 {
		fmt.Println(rev_n1)
	} else {
		fmt.Println(rev_n2)
	}
}
