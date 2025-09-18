package main

import (
	"fmt"
)

func main() {
	var n int
	fmt.Scan(&n)
	n = n / 4
	for i := 0; i < n; i++ {
		fmt.Printf("long ")
	}
	fmt.Println("int")
}
