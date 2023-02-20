dir /s /B *.java > sources.txt
javac -encoding UTF-8 -d bin @sources.txt