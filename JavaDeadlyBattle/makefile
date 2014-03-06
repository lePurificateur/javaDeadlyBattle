DIR=~/www/alexandre.mesle/enseignement/JavaDeadlyBattle45678712354

all: www

javadoc: 
	rm -fRv doc;\
	ant -v -buildfile javadoc.xml
clean:
	rm -fRv *~

jar: javadoc
	cd src/;\
	jar cfmv ../JavaDeadlyBattle.jar ../manifest.txt main/* moulinette/* specifications/*;\
	cd ../bin;\
	jar ufmv ../JavaDeadlyBattle.jar ../manifest.txt main/* moulinette/* specifications/*;\
	cd ../;\
	jar ufmv JavaDeadlyBattle.jar manifest.txt doc/*;\
	chmod 755 JavaDeadlyBattle.jar

www: jar
	rm -fRv $(DIR);\
	mkdir -pv $(DIR);\
	cp -Rv doc/* $(DIR)/;\
	cp -v JavaDeadlyBattle.jar $(DIR)/;\

send: www
	send
