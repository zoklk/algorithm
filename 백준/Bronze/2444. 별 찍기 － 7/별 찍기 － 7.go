package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	scanner.Scan()
	n, _ := strconv.Atoi(scanner.Text())

	for i := 0; i < n; i++ {
		spaces := strings.Repeat(" ", n-i-1)
		stars := strings.Repeat("*", 2*i+1)
		fmt.Fprintln(writer, spaces+stars)
	}
	for i := n - 2; i >= 0; i-- {
		spaces := strings.Repeat(" ", n-i-1)
		stars := strings.Repeat("*", 2*i+1)
		fmt.Fprintln(writer, spaces+stars)
	}
}
