
class Solution {
public:
    struct Node{
        int maxLen; 
        char leftChar; 
        char rightChar; 
        int prefix; 
        int suffix; 
    };
    vector<Node> segTree;

    Node Merge(Node& left, Node& right, int leftLen, int rightLen){
        Node newNode; 
        newNode.leftChar = left.leftChar; 
        newNode.rightChar = right.rightChar; 
        newNode.prefix = left.prefix; 
        if(left.prefix == leftLen && right.leftChar == left.rightChar){
            newNode.prefix = left.prefix + right.prefix; 
        }

        newNode.suffix = right.suffix; 
        if(right.suffix == rightLen && right.leftChar == left.rightChar){
            newNode.suffix = left.suffix + right.suffix; 
        }

        newNode.maxLen = max(left.maxLen, right.maxLen);
        if(left.rightChar == right.leftChar){
            newNode.maxLen = max(newNode.maxLen, left.suffix + right.prefix);
        }

        return newNode; 
    }   
    void buildSegTree(int i, int l, int r, const string& s){
        if(l == r){
            // root node
            segTree[i].maxLen = 1; 
            segTree[i].leftChar = s[l];
            segTree[i].rightChar = s[l];
            segTree[i].prefix = 1;
            segTree[i].suffix = 1;
            return; 
        }

        int mid = l + (r - l)/2; 
        buildSegTree(2*i + 1, l, mid, s);
        buildSegTree(2*i + 2, mid + 1, r, s);
        // merge the two nodes
        segTree[i] = Merge(segTree[2*i + 1], segTree[2* i + 2], mid - l + 1, r - mid);
    }

    void updateSegTree(int idx,int i, int l, int r, char newVal){
        if(l == r){
            // this is the idx to update 
            segTree[i].leftChar = newVal;
            segTree[i].rightChar = newVal;
            return; 
        }

        int mid = l + (r - l)/2; 

        if(idx <= mid){
            // go left 
            updateSegTree(idx, 2*i + 1, l, mid, newVal);

        } else {
            // go right 
            updateSegTree(idx, 2*i + 2, mid + 1, r, newVal);
        }

        segTree[i] = Merge(segTree[2*i + 1], segTree[2* i + 2], mid - l + 1, r - mid);
    }



    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        int n = s.length();
        segTree.resize(4 * n);
        buildSegTree(0, 0, n - 1, s);
        int k = queryCharacters.size();
        vector<int> res(k, -1);
        for(int i = 0; i < k; i++){
            updateSegTree(queryIndices[i], 0, 0, n -1, queryCharacters[i]);
            res[i] = segTree[0].maxLen; 
        }

        return res; 
    }
};