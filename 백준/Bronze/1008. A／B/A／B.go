package main

import (
	"fmt"
)

func main() {
	var n1, n2 float64
	fmt.Scanf("%f %f\n", &n1, &n2)
	fmt.Printf("%.9f\n", n1/n2)
}