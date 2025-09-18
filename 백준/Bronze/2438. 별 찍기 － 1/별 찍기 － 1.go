// 입출력 순서만 정확하면 되서, 한번에 입력받고 출력할 필요가 없다.

package main

import "fmt"

func main() {
	var n int
	fmt.Scan(&n)

	for i := 1; i <= n; i++ {
		for j := 0; j < i; j++ {
			fmt.Printf("*")
		}
		fmt.Printf("\n")
	}
}
