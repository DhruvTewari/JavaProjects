#include<iostream>
#include<queue>
using namespace std;
struct tree
{
    int data;
    struct tree *left;
    struct tree *right;
};
struct tree* newNode(int key) 
{ 
    struct tree * temp = new tree(); 
    temp->data = key; 
    temp->left = temp->right = NULL; 
    return temp; 
}; 
void preorder(struct tree *root)
{
    if(root == NULL)
    {
        return;
    }
    else{
        cout<<root->data<<endl;
        preorder(root->left);
        preorder(root->right);
    }
}

void inorder(tree * root)
{
    if(root == NULL)
    {
        return;
    }
    inorder(root->left);
    cout<<root->data<<endl;
    inorder(root->right);
}

void postorder(tree * root)
{
    if(root == NULL)
    {
        return;
    }
    postorder(root->left);
    postorder(root->right);
    cout<<root->data<<endl;
}
void level_order(tree *root)
{
    queue<tree*> q;
    q.push(root);
    while(!q.empty())
    {
        tree *temp = q.front();
        q.pop();
        if(temp->left)
        {
            q.push(temp->left);
        }
        if(temp->right)
        {
            q.push(temp->right);
        }
        cout<<temp->data<<endl;
    }
}


int main()
 {
    struct tree *root = newNode(1);
    root->left = newNode(2); 
    root->left->left = newNode(4); 
    root->left->right = newNode(5);
    root->right = newNode(3); 
    root->right->left = newNode(6); 
    root->right->right = newNode(7); 
    //preorder dlr
    //preorder(root);

    //inorder(root);

    //postorder(root);

    level_order(root);


 }