import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Interpreter extends DelphiBaseVisitor<Void> {

    private Map<String, Integer> variables = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);


    // Override visit methods to add new grammar's functionalities.
    @Override
    public Void visitReadStatement(DelphiParser.ReadStatementContext ctx) {
        String variableName = ctx.variable().getText(); // Get the variable Name to save it to
        System.out.print("Enter an integer value for " + variableName + ": "); // Prompt input
        int value = scanner.nextInt(); //Read Input

        variables.put(variableName, value);  //Update value for the user input.

        return null;
    }

    @Override
    public Void visitPrintStatement(DelphiParser.PrintStatementContext ctx) {
        // Get the text of the expression (this will be the string literal or the expression text)
        String expressionText = ctx.expression().getText();

        // Print the raw string
        System.out.println(expressionText);
        return null;
    }


    @Override
    public Void visitClassType(DelphiParser.ClassTypeContext ctx) {
        String className = null;
        String parentClassName = null;

        // Extract the class name from TypeDefinitionContext
        ParseTree parent = ctx.getParent();
        while (parent != null) {
            if (parent instanceof DelphiParser.TypeDefinitionContext) {
                className = ((DelphiParser.TypeDefinitionContext) parent).identifier().getText();
                break;
            }
            parent = parent.getParent();
        }

        // Check if inheritance is specified
        if (ctx.getChildCount() > 2 && ctx.getChild(1).getText().equals("(")) {
            parentClassName = ctx.getChild(2).getText();
        }

        // Print class information
        if (parentClassName != null) {
            System.out.println("Class: " + className + " inherits " + parentClassName);
        } else {
            System.out.println("Class: " + className);
        }

        // Preserve existing functionality (members, methods, etc.)
        if (ctx.fieldList() != null && ctx.fieldList().fixedPart() != null) {
            for (int i = 0; i < ctx.fieldList().fixedPart().recordSection().size(); i++) {
                DelphiParser.RecordSectionContext recordSectionContext = ctx.fieldList().fixedPart().recordSection(i);
                String type = recordSectionContext.type_().getText();
                for (int j = 0; j < recordSectionContext.identifierList().identifier().size(); j++) {
                    String memberName = recordSectionContext.identifierList().identifier(j).getText();
                    System.out.println("  Member Variable: " + memberName + " : " + type);
                }
            }
        }

        return visitChildren(ctx);
    }


    @Override
    public Void visitInterfaceType(DelphiParser.InterfaceTypeContext ctx) {
        String interfaceName = null;


        // Extract the class name from TypeDefinitionContext
        ParseTree parent = ctx.getParent();
        while (parent != null) {
            if (parent instanceof DelphiParser.TypeDefinitionContext) {
                interfaceName = ((DelphiParser.TypeDefinitionContext) parent).identifier().getText();
                break;
            }
            parent = parent.getParent();
        }


        System.out.println("Interface: " + interfaceName);
        // Preserve existing functionality (members, methods, etc.)
        if (ctx.fieldList() != null && ctx.fieldList().fixedPart() != null) {
            for (int i = 0; i < ctx.fieldList().fixedPart().recordSection().size(); i++) {
                DelphiParser.RecordSectionContext recordSectionContext = ctx.fieldList().fixedPart().recordSection(i);
                String type = recordSectionContext.type_().getText();
                for (int j = 0; j < recordSectionContext.identifierList().identifier().size(); j++) {
                    String memberName = recordSectionContext.identifierList().identifier(j).getText();
                    System.out.println("  Member Variable: " + memberName + " : " + type);
                }
            }
        }

        return visitChildren(ctx);
    }


    @Override
    public Void visitClassfunctionDeclaration(DelphiParser.ClassfunctionDeclarationContext ctx) {
        String functionName = ctx.identifier().getText();
        System.out.println("  Function: " + functionName);
        return null;
    }

    @Override
    public Void visitClassprocedureDeclaration(DelphiParser.ClassprocedureDeclarationContext ctx) {
        String procedureName = ctx.identifier().getText();
        System.out.println("  Procedure: " + procedureName);
        return null;
    }

    @Override
    public Void visitClassConstructorDeclaration(DelphiParser.ClassConstructorDeclarationContext ctx) {
        String constructorName = ctx.identifier().getText();
        System.out.println("  Constructor: " + constructorName);
        return null;
    }

    @Override
    public Void visitClassDestructorDeclaration(DelphiParser.ClassDestructorDeclarationContext ctx) {
        String destructorName = ctx.identifier().getText();
        System.out.println("  Destructor: " + destructorName);
        return null;
    }


    @Override
    public Void visitRecordType(DelphiParser.RecordTypeContext ctx) {
        String recordName = null;

        ParseTree parent = ctx.getParent();
        while (parent != null) {
            if (parent instanceof DelphiParser.TypeDefinitionContext) {
                recordName = ((DelphiParser.TypeDefinitionContext) parent).identifier().getText();
                break;
            }
            parent = parent.getParent();
        }

        System.out.println("Record: " + recordName);


        if(ctx.fieldList() != null && ctx.fieldList().fixedPart() != null) {
            for (int i = 0; i < ctx.fieldList().fixedPart().recordSection().size(); i++) {
                DelphiParser.RecordSectionContext recordSectionContext = ctx.fieldList().fixedPart().recordSection(i);
                String type = recordSectionContext.type_().getText();
                for(int j = 0; j < recordSectionContext.identifierList().identifier().size(); j++){
                    String memberName = recordSectionContext.identifierList().identifier(j).getText();
                    System.out.println("  Member Variable: " + memberName + " : " + type);
                }
            }

        }
        return visitChildren(ctx);
    }

    @Override
    public Void visitFunctionDeclaration(DelphiParser.FunctionDeclarationContext ctx) {
        String functionName = ctx.identifier().getText();
        System.out.println("Function: " + functionName);
        return null;
    }

    @Override
    public Void visitProcedureDeclaration(DelphiParser.ProcedureDeclarationContext ctx) {
        String procedureName = ctx.identifier().getText();
        System.out.println("Procedure: " + procedureName);
        return null;
    }


}