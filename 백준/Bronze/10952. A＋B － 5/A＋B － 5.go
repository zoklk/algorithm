package main

import "fmt"

func main() {
	var a, b int
	for {
		fmt.Scan(&a, &b)
		if a+b == 0 {
			break
		}
		fmt.Println(a + b)
	}
}
