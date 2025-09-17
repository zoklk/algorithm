package main

import (
	"fmt"
)

func main() {
	var n1 int
	fmt.Scan(&n1)
	for i := 1; i < 10; i++ {
		fmt.Printf("%d * %d = %d\n", n1, i, n1*i)
	}
}
