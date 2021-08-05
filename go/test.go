package main

import (
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
	"strings"
)

func check(e error) {
	if e != nil {
		panic(e)
	}
}

func stringToIntArray(rowStr []string) []int {
	var tempIntRows = []int{}
	var x = 0
	for _, i := range rowStr {
		j, err := strconv.Atoi(i)
		check(err)
		x += j
		tempIntRows = append(tempIntRows, j)
	}
	return tempIntRows
}

func avarageOfRows() [24]float32 {

	content, err := ioutil.ReadFile("numbers.txt")
	check(err)

	strContent := string(content[:])
	row := strings.Split(strContent, "\r\n")
	var sumRow [24]float32
	var avgRow [24]float32

	for i := 0; i < 24; i++ {

		numbersInRow := strings.Split(row[i], "\t")

		var tempIntRows = stringToIntArray(numbersInRow)

		for j := 0; j < 10; j++ {
			sumRow[i] += float32(tempIntRows[j])
			avgRow[i] = sumRow[i] / 10 //avarage
		}
	}
	return avgRow
}

func writeFileFloatArray(arrayToWrite [24]float32) {
	f, err := os.Create("avarageRows")
	check(err)
	for i := range arrayToWrite {
		tempStr := fmt.Sprintf("%.1f", arrayToWrite[i])
		fmt.Fprintf(f, tempStr+"\n")
	}
	f.Close()
}

func writeFile(numberToWrite float32) {
	f, err := os.Create("avarageAll")
	check(err)

	tempStr := fmt.Sprintf("%.1f", numberToWrite)
	fmt.Fprintf(f, tempStr)
	f.Close()
}

func avgFloatArray(arrayToTakeAvg [24]float32) float32 {
	arraySize := len(arrayToTakeAvg)
	var sum float32
	sum = 0

	for i := 0; i < arraySize; i++ {
		sum += (arrayToTakeAvg[i])
	}
	avg := (float32(sum)) / (float32(arraySize))

	return avg
}

func main() {

	writeFileFloatArray(avarageOfRows())
	writeFile(avgFloatArray(avarageOfRows()))
}
