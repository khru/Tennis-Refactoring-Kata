default: help

help:
	@echo "The use of this commands is: make COMMAND where COMMAND could be:"
	@echo "test          runs all test on the terminal"
	@echo "pre_commit    install a pre_commit hook to format"

test:
	mvn test

pre_commit:
	@echo "Trying to copy pre-commit into .git/hooks folder"
	@cp ./pre-commit ../.git/hooks
	@chmod +x ../.git/hooks/pre-commit
	@ls -la  ../.git/hooks/ | grep pre-commit
