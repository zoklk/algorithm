package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	line, _ := reader.ReadString('\n')
	line = strings.TrimSpace(line)

	var n int
	fmt.Fscan(reader, &n)

	fmt.Printf("%c", line[n-1])
}
