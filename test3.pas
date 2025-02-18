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

  private
  function add(num1, num2: integer): integer;
  function subtract(num1,num2 :integer):integer;
  protected
  constructor Create(AName, ABook: string);
  destructor Destroy;

 end;

begin
  writeln('Hi');
end.