
package org.kevoree.modeling.java2typescript.translator;

import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiForeachStatement;
import com.intellij.psi.PsiParameter;
import org.kevoree.modeling.java2typescript.TranslationContext;
import org.kevoree.modeling.java2typescript.TypeHelper;

public class ForEachStatementTranslator extends Translator<PsiForeachStatement> {

  @Override
  public void translate(PsiElementVisitor visitor, PsiForeachStatement element, TranslationContext ctx) {

    ctx.print("//TODO resolve for-each cycle\n");

    PsiParameter parameter = element.getIterationParameter();

    ctx.print("var ");
    ctx.append(parameter.getName());
    ctx.append(": ");
    ctx.append(TypeHelper.getParameterType(parameter, ctx));
    ctx.append(";\n");

    ctx.print("for (");

    ctx.append(parameter.getName());

    ctx.append(" in ");

    element.getIteratedValue().accept(visitor);

    ctx.append(") {\n");

    ctx.increaseIdent();
    element.getBody().accept(visitor);
    ctx.decreaseIdent();

    ctx.print("}\n");
  }
}
