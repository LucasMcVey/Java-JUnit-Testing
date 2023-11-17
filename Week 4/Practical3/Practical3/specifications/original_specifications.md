

The practical will have you create various classes to give you some insight into how classes are designed and the
relationships between different classes.

# Tasks

Use the starter code in this project as a starting point and make yourself familiar with its contents.

### Task 1

This task implements commands for storing messages (`memo`), listing the current messages (`list`), and exiting
the program (`exit`).

A possible run of the program might look like this (input is in bold italics):

<pre>
    Command? <i><b>memo Today is the first day of the rest of my life!</b></i>

    Command? <i><b>memo The answer is 42</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    memo: The answer is 42

    Command? <i><b>exit</b></i>
</pre>

**Note**: the message for the `memo` command is the remainder of the line, that the `list` command displays the items in
the same order that they were entered, that the program's prompt (`Command?`) appears on the same line as the command
you type, and that there's a single blank line between each command.

Modify the program and add a command for storing phone numbers (`phone`). You will have to create a new class for this.

A possible run of the program might look like this (input is in bold italics):

<pre>
    Command? <i><b>memo Today is the first day of the rest of my life!</b></i>

    Command? <i><b>phone Bill 555-1234</b></i>

    Command? <i><b>memo The answer is 42</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    phone: Bill 555-1234
    memo: The answer is 42

    Command? <i><b>phone Mum +61-8-555-9876</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    phone: Bill 555-1234
    memo: The answer is 42
    phone: Mum +61-8-555-9876

    Command? <i><b>exit</b></i>
</pre>

**Note:** the `phone` command takes two arguments: the name of the person, and their telephone number.

### Task 2

[//]: # (need to also indicate that an intermediate class would be a good idea here)

Modify the program and add new variants of the `memo` and `phone` commands. If the commands are typed with *no
arguments*, then they display a list of just the appropriate kind of item. If they are typed *with arguments* as before,
then they record a new item.

A possible run of the program might look like this (input is in bold italics):

<pre>
    Command? <i><b>memo Today is the first day of the rest of my life!</b></i>

    Command? <i><b>phone Bill 555-1234</b></i>

    Command? <i><b>memo The answer is 42</b></i>

    Command? <i><b>phone Mum +61-8-555-9876</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    phone: Bill 555-1234
    memo: The answer is 42
    phone: Mum +61-8-555-9876

    Command? <i><b>memo</b></i>
    memo: Today is the first day of the rest of my life!
    memo: The answer is 42

    Command? <i><b>phone</b></i>
    phone: Bill 555-1234
    phone: Mum +61-8-555-9876

    Command? <i><b>exit</b></i>
</pre>

### Task 3

Modify the program and add yet another variant of the `phone` command.

- If typed with *no arguments*, it displays a list of **all** phone items.
- If typed with *one argument*, it displays a list of the phone items of names that **start with** that value.
- Finally, if typed with *two arguments*, it records a **new item** as before.

A possible run of the program might look like this (input is in bold italics):

<pre>
    Command? <i><b>memo Today is the first day of the rest of my life!</b></i>

    Command? <i><b>phone Bill 555-1234</b></i>

    Command? <i><b>memo The answer is 42</b></i>

    Command? <i><b>phone Mum +61-8-555-9876</b></i>

    Command? <i><b>phone Me 0410-123456</b></i>

    Command? <i><b>phone Mexico +52-</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    phone: Bill 555-1234
    memo: The answer is 42
    phone: Mum +61-8-555-9876
    phone: Me 0410-123456
    phone: Mexico +52-

    Command? <i><b>memo</b></i>
    memo: Today is the first day of the rest of my life!
    memo: The answer is 42

    Command? <i><b>phone</b></i>
    phone: Bill 555-1234
    phone: Mum +61-8-555-9876
    phone: Me 0410-123456
    phone: Mexico +52-

    Command? <i><b>phone Bill</b></i>
    phone: Bill 555-1234

    Command? <i><b>phone M</b></i>
    phone: Mum +61-8-555-9876
    phone: Me 0410-123456
    phone: Mexico +52-

    Command? <i><b>phone Me</b></i>
    phone: Me 0410-123456
    phone: Mexico +52-

    Command? <i><b>exit</b></i>
</pre>

### Task 4

**WARNING: Challenging!**

Modify the program to add a `todo` command with 3 variants.

- With two or more arguments, it interprets the first argument as a *date*, and the remaining arguments as a *message*,
  then records a new item for that date.
- With one argument, it displays `todo` items that fall on that day or on the previous or following day.
- With no arguments, it displays all `todo` items.

A possible run of the program might look like this (input is in bold italics):

<pre>
    Command? <i><b>phone Mum +61-8-555-9876</b></i>

    Command? <i><b>todo 25/12/2020 Call Mum!</b></i>

    Command? <i><b>todo 26/12/2020 Sleep in</b></i>

    Command? <i><b>todo 1/1/2021 Happy New Year!</b></i>

    Command? <i><b>list</b></i>
    phone: Mum +61-8-555-9876
    todo: 25/12/20 Call Mum!
    todo: 26/12/20 Sleep in
    todo: 1/01/21 Happy New Year!

    Command? <i><b>todo</b></i>
    todo: 25/12/20 Call Mum!
    todo: 26/12/20 Sleep in
    todo: 1/01/21 Happy New Year!

    Command? <i><b>todo 25/12/2020</b></i>
    todo: 25/12/20 Call Mum!
    todo: 26/12/20 Sleep in

    Command? <i><b>todo 31/12/2020</b></i>
    todo: 1/01/21 Happy New Year!

    Command? <i><b>exit</b></i>
</pre>

### Task 5

**WARNING: Challenging!**

Modify the program to add yet another variant of the `phone` command, and the `todo` command.

- For the `phone` command: If typed with *one argument*, and that argument is ''`-a`'', then it displays a list of
  the `phone` items in alphabetic order.

  In all other cases it should behave as before.

- For the `todo` command: If typed with *one argument*, and that argument is ''`-d`'', then it displays a list of
  the `todo` items in date order.

  In all other cases it should behave as before.

A possible run of the program might look like this (input is in italics):

<pre>
    Command? <i><b>memo Today is the first day of the rest of my life!</b></i>

    Command? <i><b>phone Bill 555-1234</b></i>

    Command? <i><b>memo The answer is 42</b></i>

    Command? <i><b>phone Mum +61-8-555-9876</b></i>

    Command? <i><b>phone Mexico +52-</b></i>

    Command? <i><b>phone Me 0410-123456</b></i>

    Command? <i><b>list</b></i>
    memo: Today is the first day of the rest of my life!
    phone: Bill 555-1234
    memo: The answer is 42
    phone: Mum +61-8-555-9876
    phone: Mexico +52-
    phone: Me 0410-123456

    Command? <i><b>phone</b></i>
    phone: Bill 555-1234
    phone: Mum +61-8-555-9876
    phone: Mexico +52-
    phone: Me 0410-123456
    
    Command? <i><b>phone -a</b></i>
    phone: Bill 555-1234
    phone: Me 0410-123456
    phone: Mexico +52-
    phone: Mum +61-8-555-9876

    Command? <i><b>todo 26/12/2020 Sleep in</b></i>
    
    Command? <i><b>todo 1/1/2021 Happy New Year</b></i>

    Command? <i><b>todo 25/12/2020 Call Mum!</b></i>
    
    Command? <i><b>todo -d</b></i>
    todo: 25/12/20 Call Mum!
    todo: 26/12/20 Sleep in
    todo: 1/01/21 Happy New Year!
    
    Command? <i><b>exit</b></i>
</pre>
