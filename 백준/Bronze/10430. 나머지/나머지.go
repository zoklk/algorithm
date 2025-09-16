package main

import (
	"fmt"
)

func main() {
	var n1, n2, n3 int
	fmt.Scanf("%d %d %d\n", &n1, &n2, &n3)
	fmt.Printf("%d\n", (n1+n2)%n3)
	fmt.Printf("%d\n", ((n1%n3)+(n2%n3))%n3)
	fmt.Printf("%d\n", (n1*n2)%n3)
	fmt.Printf("%d\n", ((n1%n3)*(n2%n3))%n3)
}