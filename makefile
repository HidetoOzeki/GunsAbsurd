MAIN = com/HidetoOzeki/games/gunsabsurd/Main.java

default:
	javac -encoding UTF-8 $(MAIN)
	java $(MAIN)
compile:
	javac -encoding UTF-8 $(MAIN)
run:
	java $(MAIN)