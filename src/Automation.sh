#!/bin/bash

# clean remote
rm -rf ~/P1/* &&
rm -rf ~/scratch/coen281p1/* &&

# push code from local to remote
scp -r /Users/SuryaRajasekaran/scratch/coen281p1 srajasek@linux.scudc.scu.edu:/home/srajasek/scratch

# code copy in remote
cp ~/scratch/coen281p1/src/* ~/P1/ &&
cp ~/scratch/Makefile ~/P1/ &&

# code submit in remote
cd ~/
perl Submit srajasek /home/srajasek/P1 &&
perl Autotest 1 &&

# code test results in remote
cat AutoTestDir/srajasek/out
