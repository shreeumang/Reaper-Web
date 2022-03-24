Steps to be considered before running the app:-
1.Need to copy-paste both the folder Api Application and messaging into your eclipse workspace,
2.Open the messaging folder inside that open run-Application-Api file in edit mode.
3.Just provide the path of spring.bat file which is located inside Api application folder and also provide the path for run-Angluar.bat file.
simillar to this (C:\Users\Dell\eclipse-workspace\ApiApplication\runSpring.bat)  (C:\Users\Dell\eclipse-workspace\ApiApplication\run-Angular.bat)
4.After that open both the project inside eclipse, and in Api-appplication inside src/resouces open Application.propeties file and check "server.port=8081".
if that is present then save it.
5.In the same way inside ApiApplication->Angular->angular.json file  in serve tag type "port=4300" if not present.
6.Now execute the run-Application-Api bath file.