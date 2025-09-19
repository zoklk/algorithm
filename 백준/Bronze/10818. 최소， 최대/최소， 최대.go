package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscan(reader, &n)

	min := 1000001
	max := -1000001

	var temp int
	for i := 0; i < n; i++ {
		fmt.Fscan(reader, &temp)
		if temp < min {
			min = temp
		}
		if temp > max {
			max = temp
		}
	}
	fmt.Fprintln(writer, min, max)
}
