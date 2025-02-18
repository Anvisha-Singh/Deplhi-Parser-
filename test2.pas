program ObjectTest;

type
  Calculator = class
  public
    function Add(a, b: integer): integer;
  end;

function Calculator.Add(a, b: integer): integer;
begin
  Result := a + b;
end;

var
  calc: Calculator;
  result: integer;

begin
  calc := Calculator.CREATE;
  result := calc.Add(5, 3);
  writeln('5 + 3 = ', result);
end.
