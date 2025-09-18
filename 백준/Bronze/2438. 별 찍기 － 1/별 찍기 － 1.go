package main

import "fmt"

func main() {
	var n int
	s := ""
	fmt.Scan(&n)
	for i := 1; i <= n; i++ {
		s += "*"
		fmt.Println(s)
	}
}
