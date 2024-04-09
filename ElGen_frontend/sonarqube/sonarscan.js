const scanner = require('sonarqube-scanner');

scanner(
    {
        serverUrl: 'http://localhost:9000',
        token: "sqp_7d613eb7bf57c769010b1aeb4a079b68341b0363",
        options: {
		"sonar.login": "admin",
            "sonar.password": "123",
            'sonar.projectName': 'ElGen',
            'sonar.projectDescription': 'Here I can add a description of my project',
            'sonar.projectKey': 'ElGen2024',
            'sonar.projectVersion': '0.0.1',
            'sonar.exclusions': '',
            'sonar.sourceEncoding': 'UTF-8',
		'sonar.exclusions':'**/node_modules/**, **/*.pack'

        }
    },
    () => process.exit()
)