#mvn jasypt:encrypt-value -Djasypt.encryptor.password=root -Djasypt.plugin.value=0003pray
#ENC(/+OBEb0vhfcT80ITwkISnBNjlyATgCy+o97lgI4VIohTj4ZQnj743nax9h/0LLeh)

#mvn jasypt:decrypt-value -Djasypt.encryptor.password=root -Djasypt.plugin.value=/+OBEb0vhfcT80ITwkISnBNjlyATgCy+o97lgI4VIohTj4ZQnj743nax9h/0LLeh

#-Djasypt.encryptor.password=root

#mvn jasypt:encrypt -Djasypt.encryptor.password=root  -Djasypt.plugin.path="file:src/main/resources/application.properties"
