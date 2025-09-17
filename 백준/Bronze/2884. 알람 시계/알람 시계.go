package main

import (
	"fmt"
)

func main() {
	var H, M int
	fmt.Scanf("%d %d\n", &H, &M)

	M = M - 45
	if M < 0 {
		M += 60
		H -= 1
	}

	if H < 0 {
		H += 24
	}

	fmt.Printf("%d %d\n", H, M)
}
