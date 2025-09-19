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

	var N, M int
	fmt.Fscan(reader, &N, &M)
	baskets := make([]int, N)

	for i := 0; i < N; i++ {
		baskets[i] = i + 1
	}

	for i := 0; i < M; i++ {
		var a, b int
		fmt.Fscan(reader, &a, &b)
		for a-1 < b-1 {
			baskets[a-1], baskets[b-1] = baskets[b-1], baskets[a-1]
			a++
			b--
		}
	}

	for i := 0; i < N; i++ {
		fmt.Fprintf(writer, "%d ", baskets[i])
	}

}
