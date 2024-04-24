public class DeepCopyReference implements Cloneable {
    @Override
    protected DeepCopyReference clone() throws CloneNotSupportedException {
        return (DeepCopyReference) super.clone();
    }
}