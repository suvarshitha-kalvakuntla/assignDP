
public class ProductIterator implements ListIterator {
    private ClassProductList classProductList;
    private int i;


    public ProductIterator(ClassProductList listOfProducts){
        i=0;
        classProductList=listOfProducts;

    }

    public boolean hasNext() {
        if(this.i < classProductList.size()){
            return true;
        }
        return false;

    }

    public Product Next() {
        Product p=null;
        if (this.hasNext()) {

            return (Product) classProductList.get(i++);
        } else {
            return null;
        }
    }

    public void MoveToHead() {

    }

    public void Remove() {

    }
}
