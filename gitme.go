package main

import (
	"fmt"
	"os/exec"
	"github.com/CrowdSurge/banner"
	"os"
)

func menu() {

	banner.Print("gitme")
	fmt.Println("")
	fmt.Println("Version: 1.1")
	fmt.Println("----------------------------------------")
	fmt.Println("The following options are availible below:")
	fmt.Println("(1) Build Gradle Project")
	fmt.Println("(2) Update Gradle Wrapper")
	fmt.Println("(3) Add all files to git")
	fmt.Println("(4) Commit files to git")
	fmt.Println("(5) Push files to git")
	fmt.Println("(6) Commit and push to git")
	fmt.Println("(7) More options")
	fmt.Println("(8) Exit Gitme")
	fmt.Println("Type 'menu' to return to this menu")
}

func main() {
	menu()
	for true {
		input()
	}
}

func runExec(command string, args1 string, args2 string) {
	c := exec.Command(command,args1,args2)
	bs,err := c.CombinedOutput();

	fmt.Printf("%s", bs)

	if(false) {
		fmt.Printf("Error", err)
	}

}

func input() {
	var input string
	fmt.Print("$ ")
	fmt.Scanln(&input)

	switch input {
	case "1":
		fmt.Println("Building Gradle project please wait...")

		c := exec.Command("gradlew", "build")
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if err != nil {
			fmt.Println("Error: Gradle is not found in current directory!")
		}

		fmt.Println("")

	case "2":
		c := exec.Command("gradlew", "wrapper")
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}

		fmt.Println("")

	case "3":
		c := exec.Command("git", "add",".")
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}
		fmt.Println("")

	case "4":
		fmt.Println("Enter a Commit Message:")
		var inputCommit string
		fmt.Scanln(&inputCommit)


		c := exec.Command("git", "commit","-m",inputCommit)
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}
		fmt.Println("")

	case "5":
		c := exec.Command("git", "push")
		bs,err := c.CombinedOutput()

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}
	case "6":
		fmt.Println("Enter a Commit Message:")
		var inputCommit string
		fmt.Scanln(&inputCommit)


		c := exec.Command("git", "commit","-m",inputCommit)
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}

		cc := exec.Command("git", "push")
		bss,errr := cc.CombinedOutput()

		fmt.Printf("%s", bss)

		if(false) {
			fmt.Printf("Error", errr)
		}
		fmt.Println("")

	case "7":
		fmt.Println("")
	case "8":
		os.Exit(0)
	case "menu":
		menu()

	default:

		c := exec.Command(input)
		bs,err := c.CombinedOutput();

		fmt.Printf("%s", bs)

		if(false) {
			fmt.Printf("Error", err)
		}

	}
}