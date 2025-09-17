package main

import (
	"fmt"
)

func main() {
	var n1, n2, n3, prize int
	fmt.Scanf("%d %d %d\n", &n1, &n2, &n3)

	if n1 == n2 && n2 == n3 {
		prize = 10000 + n1*1000
	} else if n1 == n2 || n2 == n3 {
		prize = 1000 + 100*n2
	} else if n3 == n1 {
		prize = 1000 + 100*n3
	} else {
		largest := n1
		if n2 > largest {
			largest = n2
		}
		if n3 > largest {
			largest = n3
		}
		prize = 100 * largest
	}

	fmt.Println(prize)
}
