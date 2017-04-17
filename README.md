# coen281p1
Surya Rajasekaran

p1 assignment link : http://www.cse.scu.edu/~mwang2/mining/p1.pdf

- The program executes as per Autotest execution style
- The flow in stages is as follows :
    - read all documents
    - SHINGLING stage :
        - use k=9 for shingle size, and find all shingles for documents
        - construct the binary-matrix from the shingles obtained from documents
    - MINHASHING stage :
        - I find out the total number of shingles, i.e. N from above step, and calculate the number of permutations as abs(root(N))
        - for permutations I use the hashing approach
        - hash the shingles with abs(root(N)) different hash functions obtained by XOR operation
        - take the minimum of those hash values and create a signature column for each document
        - construct the signature-matrix
    - LSH stage :
        - calculate optimal b & r, using the d1,d2,p1,p2
        - obtain the b & r values
        - split the signature-matrix into banded-signature-matrix
        - hash the document columns in each of those bands, and bucket the same hash values - indicates which documents share the same buckets in a band
        - construct the banded-matrix (by AND) operation
        - contruct the final-matrix (by OR) operation

