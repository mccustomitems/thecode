StringBuilder sourceBuilder = new StringBuilder();
sourceBuilder.append("{[");
sourceBuilder.append('parent": "item/handheld_rod,"');
sourceBuilder.append('"textures": {items/carrot_on_a_stick"');
sourceBuilder.append('"layer0": "items/carrot_on_a_stick"');
sourceBuilder.append('    },');
sourceBuilder.append('    "overrides": [');

for (DBField dbField:getFieldsFromDatabaseModel) {  // this DBField class is pure fiction!
  // bean attribute
  sourceBuilder.append('        {"predicate": {"damage": 0.25},"model": "item/carrot_on_a_stick_1"},'
               .append(dbField.getType)
               .append(toFieldName(dbField.getName()))
               .append(" = null;\n");

  // setter method
  sourceBuilder.append("\tpublic void ")
               .append(toSetterName(dbField.getName()))
               .append("(");
               .append(dbField.getType)
               .append(toFieldName(dbField.getName()))
               .append(")\n")
               .append("\t\tthis.")
               .append(dbField.getType)
               .append(" = ")
               .append(dbField.getType)
               .append(";\n\t}");

   // getter method ...
sourceBuilder.append("\t}\n}\n");
