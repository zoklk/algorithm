package main

import "fmt"

func main() {
	var t int
    fmt.Scan(&t)

	for i := 1; i <= t; i++ {
		var a, b int
		fmt.Scan(&a, &b)
		fmt.Printf("Case #%d: %d\n", i, a+b)
	}
}