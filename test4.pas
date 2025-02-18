program x (x);

type
  T = record
    Name: string ;
    Name2 : string ;

  end;

  type
  T1 = class
  public
      Name: string ;
      Book: string;


  function add(num1, num2: integer): integer;
  function subtract(num1,num2 :integer):integer;
  constructor Create(AName, ABook: string);
  destructor Destroy;

  end;
 constructor T1.Create(AName, ABook: string);
begin
  Name := AName;
  Book := ABook;
end;

function T1.Add(a, b: integer): integer;
begin
  Result := a + b;
end;

function T1.Subtract(a, b: integer): integer;
begin
  Result := a - b;
end;


begin
  writeln('Hi');
end.