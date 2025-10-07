package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	input, _ := reader.ReadString('\n')

	word := strings.ToUpper(strings.TrimSpace(input))

	counts := make([]int, 26)

	for _, char := range word {
		counts[char-'A']++
	}

	maxCount := 0
	for _, count := range counts {
		if count > maxCount {
			maxCount = count
		}
	}

	var resultChar rune
	tieCount := 0
	for i, count := range counts {
		if count == maxCount {
			tieCount++
			resultChar = rune('A' + i)
		}
	}

	if tieCount > 1 {
		fmt.Println("?")
	} else {
		fmt.Printf("%c\n", resultChar)
	}
}