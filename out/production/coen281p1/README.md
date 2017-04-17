# coen281p1
Surya Rajasekaran

p1 assignment link : http://www.cse.scu.edu/~mwang2/mining/p1.pdf

- The program executes as per Autotest execution style
- The code flow in stages as follows :
    - reads all documents
    - SHINGLING stage :
        - use k=9 for shingle size, and find all shingles for documents
        - construct the binary-matrix for the shingles obtained from documents
    - MINHASHING stage :
        - find out the total number of shingles, i.e. N from above step, and calculate the number of permutations as abs(root(N))
        - for permutations I use the hashing approach
        - hash the shingles with abs(root(N)) different hash functions, which are obtained by XOR operation
        - take the minimum of those hash values and create a signature column for each document
        - construct the signature-matrix
    - LSH stage :
        - calculate optimal b & r, using the d1,d2,p1,p2 from question
        - obtain the b & r values
        - split the signature-matrix into banded-signature-matrix
        - hash the document columns in each of those bands, and bucket the same hash values
        - documents sharing the same buckets in a band are likely similar
        - construct the banded-document-matrix (by AND) operation
        - contruct the final-document-matrix (by OR) operation

