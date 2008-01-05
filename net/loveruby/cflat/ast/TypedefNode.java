package net.loveruby.cflat.ast;
import net.loveruby.cflat.type.*;

public class TypedefNode extends TypeDefinition {
    protected TypeNode real;

    public TypedefNode(Location loc, TypeRef real, String name) {
        super(loc, new UserTypeRef(name), name);
        this.real = new TypeNode(real);
    }

    public boolean isUserType() {
        return true;
    }

    public TypeNode realTypeNode() {
        return real;
    }

    public Type realType() {
        return real.type();
    }

    public TypeRef realTypeRef() {
        return real.typeRef();
    }

    public void defineIn(TypeTable table) {
        table.defineUserType(this);
    }

    protected void _dump(Dumper d) {
        d.printMember("name", name);
        d.printMember("typeNode", typeNode);
    }

    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
