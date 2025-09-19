package main

import "fmt"

func main() {
	var a, x int
	fmt.Scan(&a)
	counts := make([]int, 201)
	for i := 0; i < a; i++ {
		var temp int
		fmt.Scan(&temp)
		counts[temp+100]++
	}
	fmt.Scan(&x)
	fmt.Println(counts[x+100])
}
