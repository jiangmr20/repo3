git pull origin master
svn revert -R ./
svn update
git add .
git commit -m "update project"
git push origin master
pause