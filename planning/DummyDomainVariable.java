package planning;
import java.util.HashSet;
import java.util.Set;
import representation.Variable;
public class DummyDomainVariable extends Variable {
        /** Must be at least 2. */
        static final int NB_VALUES = 5;
        
        static final Set<Object> DOMAIN = new HashSet<>();
        public DummyDomainVariable(String name) {
                super(name, DummyDomainVariable.DOMAIN);
        }
        @Override
        public String toString() {
                return super.getName();
        }
        
}